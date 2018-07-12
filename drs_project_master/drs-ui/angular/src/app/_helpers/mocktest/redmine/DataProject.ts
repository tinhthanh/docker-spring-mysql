import { Trackers } from './../../../_models/redmine-api/Trackers';
import { Project } from './../../../_models/redmine-api/Project';

export class DataProject {
    public project: Project[] = [];
    constructor() {
         const temp1: Project = {
            id: 1,
            name: 'Redmine',
            identifier: 'redmine',
            description: 'Redmine is a flexible project management web application written using Ruby on Rails framework.',
            homepage: '',
            status: 1,
            created_on: '2007-09-29T10:03:04Z',
            updated_on: '2009-03-15T11:35:11Z',
            trackers: [
              {
                id: 1,
                name: 'Defect'
              },
              {
                id: 2,
                name: 'Feature'
              },
              {
                id: 3,
                name: 'Patch'
              }
            ]
          };
          this.createProject(temp1);
          const temp2: Project = {
            id: 1,
            name: 'Redmine2',
            identifier: 'redmine2',
            description: 'Redmine is a flexible project management web application written using Ruby on Rails framework.',
            homepage: '',
            status: 1,
            created_on: '2007-09-29T10:03:04Z',
            updated_on: '2009-03-15T11:35:11Z',
            trackers: [
              {
                id: 1,
                name: 'Defect'
              },
              {
                id: 2,
                name: 'Feature'
              },
              {
                id: 3,
                name: 'Patch'
              }
            ]
          };
        this.createProject(temp2);
    }
    public createProject(project: Project ) {
    this.project.push(project);
    }
}
