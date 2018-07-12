import { HttpErrorResponse } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Project } from './../../../_models/redmine-api/Project';
import { ProjectService } from './../../../_services/manager/project/project.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-project-list',
  templateUrl: './project-list.component.html',
  styleUrls: ['./project-list.component.css']
})
export class ProjectListComponent implements OnInit {
  public projects: Observable<Project[]>;

  public list: Project[];
  constructor(private projectService: ProjectService) { }
  ngOnInit() {
    this.projects = this.projectService.getAllProject();
    this.projectService.getAllProject().subscribe((data: Project[]) => {
      this.list = data;
    }, (err: HttpErrorResponse) => {
      console.log(err.status);
    });
  }
}
