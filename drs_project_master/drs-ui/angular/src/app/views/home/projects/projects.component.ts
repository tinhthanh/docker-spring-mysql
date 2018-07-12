import { config } from './../../../_models/config';
import { ProjectService } from './../../../_services/manager/project/project.service';
import { Component, OnInit, HostListener } from '@angular/core';
// import { fakeProjects } from './../../../_helpers/mocktest/fake-data/fake-projects';
import { DropEvent } from 'ng-drag-drop';
import { Router } from '@angular/router';
@Component({
  selector: 'app-projects',
  templateUrl: './projects.component.html',
  styleUrls: ['./projects.component.css']
})
export class ProjectsComponent implements OnInit {
  listProject: any[];
  listSelect: any[] = [];
  daysOfWeek = [
    'Sun',
    'Mon',
    'Tue',
    'Wed',
    'Thu',
    'Fri',
    'Sat'
  ];
  vegetables = [
    { name: 'Carrot', type: 'vegetable' },
    { name: 'Onion', type: 'vegetable' },
    { name: 'Potato', type: 'vegetable' },
    { name: 'Capsicum', type: 'vegetable' }];

  droppedVegetables = [];

  isShowListSelect = false;
  public projectList = [];
  @HostListener('window:resize', ['$event'])
  onResize(event) {
    if (event.target.innerWidth > 999) {
      this.isShowListSelect = false;
    }
  }
  constructor(private projectService: ProjectService,
    private router: Router) {
      if (!localStorage.getItem(config.client.userToken)) {
        this.router.navigate(['/dashboard/login']);
      }
  }

  ngOnInit() {
    this.projectService.getAllProject().subscribe( ( data: any) => {
      this.projectList = data;
      console.log(this.projectList);
      this.listProject = this.handlerData();
  });
  }
  public removeSelect($event) {
      this.listSelect.forEach((item , index ) => {
         if ( item.id === $event.id ) {
           this.listProject.forEach(temp => {
              const ng: number = $event.createOn ;
              console.log($event.createOn);
              console.log($event);
              const date  = new Date(ng);
              console.log(date);
              if ( temp.yaer === date.getFullYear()) {
                temp.data.push($event);
                return true;
              }
           });
           this.listSelect.splice(index, 1);
         }
      });
      return false;
      }
      public removeAllSelect() {
        console.log(this.listSelect);
        while ( this.listSelect.length !== 0 ) {
          this.listSelect.forEach( ( item , index ) => {
            this.removeSelect(item);
         });
      }
    }
    public addSelect(id: number) {
    this.listProject.forEach( root => {
      root.data.forEach((child , index) => {
         if (child.id === id ) {
           this.listSelect.push(root.data[index]);
          // console.log(root.data[index]);
           root.data.splice(index, 1);
         }
      });
    });
    }
  public handlerData(): any[] {
    const set = new Set<number>();
    this.projectList.forEach((item: any) => {
    //  const temp: number = item.createOn;
    //  const date = new Date(item.createdOn).getFullYear();
    //   const d1 = new Date(1516337206000);
    //   const d2 = new Date(temp);
    //   console.log(d2.getFullYear());
    const temp: number = item.createOn;
    const date = new Date(temp);
     set.add(date.getFullYear());
    });
    const hanldData: any[] = [];
    set.forEach((item: number) => {
      const matchedProjects = this.projectList.filter((temp: any) =>  {
        const ng: number = temp.createOn;
        return (new Date(ng)).getFullYear() === item;
      });
      hanldData.push({ yaer: item, data: matchedProjects });
    });
    console.log(hanldData);
    return hanldData;
  }
  public getMonth(date: number): number {
    return (new Date(date).getDate());
  }
  public getDay(date: number): string {
    return this.daysOfWeek[new Date(date).getDay()];
  }
  onVegetableDrop(e: DropEvent) {
    this.droppedVegetables.push(e.dragData);
    this.removeItem(e.dragData, this.vegetables);
    console.log(this.droppedVegetables);
  }
  removeItem(item: any, list: Array<any>) {
    const index = list.map((e) => {
      return e.name;
    }).indexOf(item.name);
    list.splice(index, 1);
  }
  public goToIssues() {
    console.log(this.listSelect);
    const listId = [] ;
    this.listSelect.forEach( p => {
          listId.push(p.id);
    });
    console.log(listId);
    this.router.navigate(['/dashboard/issues-projects'], { queryParams: { pId: listId} });
  }
}
