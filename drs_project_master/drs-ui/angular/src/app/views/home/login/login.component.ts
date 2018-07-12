import { config } from './../../../_models/config';
import { UserTokenState } from './../../../_models/user/user-token-state';
import { AuthService } from './../../../_services/manager/user/auth.service';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Validators, FormControl, FormGroup, FormBuilder } from '@angular/forms';
import { Router, ActivatedRoute } from '@angular/router';
import { cacheStorage } from '../../../_cache/cacheStorage';
import { setTimeout } from 'timers';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
  providers: [AuthService]
})
export class LoginComponent implements OnInit {
  public sms: string; // error report
  public isLogin = false; // hide button login
  private userRemember: any = {}; //  variable save the password
  private userTokenState: UserTokenState; // model save jwt
  private returnUrl: string; //
  loginFormGroup: FormGroup;
  constructor(private fb: FormBuilder,
    private http: HttpClient,
    private router: Router,
    private route: ActivatedRoute,
    private authService: AuthService
  ) {
    if (localStorage.getItem(config.client.userToken)) { this.router.navigate(['/dashboard/issues-projects']); }
  }

  ngOnInit() {
    this.returnUrl = this.route.snapshot.queryParams['returnUrl'] || '/';
    if (localStorage.getItem(config.client.remember)) {
      this.userRemember = JSON.parse(atob(localStorage.getItem(config.client.remember)));
    }
    if ( !this.route.snapshot.queryParams['returnUrl']  ) {
      this.returnUrl =  '/';
   } else {
      const returnUrl = this.route.snapshot.queryParams['returnUrl'] ;
      const v = returnUrl.split('?');
          this.returnUrl = v[0];
   }
    if (!this.userRemember) {
      // the case user didnt choose to save login infor
      this.userRemember = {};
      this.userRemember.userName = '';
      this.userRemember.password = '';
      this.userRemember.rememberMe = false;
    }
    this.loginFormGroup = new FormGroup({
      userName: new FormControl(this.userRemember.userName, [
        Validators.required,
        // tslint:disable-next-line:max-line-length
        Validators.pattern(/^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?![_.])$/)
      ]),
      password: new FormControl(this.userRemember.password, [
        Validators.pattern(/^(?=.*[A-Z\u00C0-\u00DF].*)(?=.*[0-9].*)(?=.*[a-z\u00E0-\u00FF].*).{8,}$/),
        Validators.required,
      ]),
      rememberMe: new FormControl(this.userRemember.rememberMe)
    });
  }
  /**
   * login process funtion
   */
  public login(): void {
    localStorage.removeItem(config.client.userToken);
    localStorage.removeItem(cacheStorage.listTask.today);
    localStorage.removeItem(cacheStorage.listTask.tomorrow);
    localStorage.removeItem(config.client.info);
    sessionStorage.clear();
    if (!this.isLogin) {
      this.isLogin = true; // dissable login button
      this.sms = null; // error message
      const userName: string = this.loginFormGroup.get('userName').value;
      const password: string = this.loginFormGroup.get('password').value;

      this.authService.authLogin(userName, password).subscribe((data) => {
        if (this.loginFormGroup.value.rememberMe) {
          // save user login info to local storage
          localStorage.setItem(config.client.remember, btoa(JSON.stringify(this.loginFormGroup.value)));
        }
        this.isLogin = false;
        setTimeout( () => {
         this.router.navigate(['/dashboard/issues-projects']);
        }, 100 ) ;
      }, (err: HttpErrorResponse) => {
        if (err.status === 403) {
          this.sms = 'invalid username or password';
        }
        if (err.status === 0) {
          this.sms = 'server is not available';
        }
        this.isLogin = false;
      });

    }
  }
}
