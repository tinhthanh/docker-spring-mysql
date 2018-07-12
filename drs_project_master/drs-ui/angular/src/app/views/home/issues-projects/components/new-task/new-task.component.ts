import { Component, OnInit, EventEmitter, Output , Input } from '@angular/core';
import { Validators, FormControl, FormGroup, FormBuilder } from '@angular/forms';
import { CustomTaskRestService } from '../../../../../_services/custom-task-rest/custom-task-rest.service';
@Component({
  selector: 'app-new-task',
  templateUrl: './new-task.component.html',
  styleUrls: ['./new-task.component.css']
})
export class NewTaskComponent implements OnInit {
  dateNow = new Date();
  formTask: FormGroup;
  @Input() task: any ; // Task
  @Output()
  addNewTask: EventEmitter<any> = new EventEmitter<any>();
  @Output()
  resultEditCustomTask: EventEmitter<any> = new EventEmitter<any>();
  constructor(private customTaskRestService: CustomTaskRestService) { }

  ngOnInit() {
    this.initFroms(this.task);
    console.log(this.task);
  }
  public saveTask() {
   if ( this.formTask.valid ) {
    if ( this.task ) {
      console.log(this.task);
      this.formTask.value.custom_task_id = this.task.custom_task_id ;
      this.customTaskRestService.editCustomTask(this.formTask.value).subscribe((res: any) => {
        console.log(res);
        this.task = res;
        this.resultEditCustomTask.emit(this.task);
      });
    } else {
      console.log(this.formTask.value);
      this.customTaskRestService.addCustomTask(this.formTask.value).subscribe( (res: any) => {
       this.addNewTask.emit(this.formTask.value);
         console.log(res);
      });
    }
   }
   this.task = null;
  }
  public initFroms(task: any ) {
    this.task = task ;
     if ( task ) {
      this.formTask = new FormGroup({
        status: new FormControl( task.task_status , [
          Validators.required,
          Validators.min(0),
          Validators.max(100)
        ]),
        targetDate: new FormControl( new Date( task.target_date) , [
          Validators.required,
        ]),
        taskName: new FormControl( task.task_name , [
          Validators.required,
        ]),
        description: new FormControl( task.description , [
          Validators.required,
        ]),
        remark: new FormControl(task.remark)
      });
     } else {
      this.formTask = new FormGroup({
        status: new FormControl(0, [
          Validators.required,
          Validators.min(0),
          Validators.max(100)
        ]),
        targetDate: new FormControl(new Date(), [
          Validators.required,
        ]),
        taskName: new FormControl('', [
          Validators.required,
        ]),
        description: new FormControl('', [
          Validators.required,
        ]),
        remark: new FormControl('')
      });
     }
  }

}
