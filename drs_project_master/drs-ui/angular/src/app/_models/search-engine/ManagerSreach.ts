import { SearchEngine } from './SearchEngine';


export class ManagerSearch {
    constructor() {
    }
    public items   = [ {
        id: 'ID1',
        text: 'Status',
      },
      {
        id: 'ID2',
        text: 'Tracker'
      },
      {
        id: 'ID3',
        text: 'Priority'
      },
    //   {
    //     id: 'ID4',
    //     text: 'Assignee'
    //   }
    //   ,
    //   {
    //     id: 'ID5',
    //     text: 'Subject'
    //   },
    //   {
    //     id: 'ID6',
    //     text: 'Description'
    //   }, {
    //       id: 'ID7',
    //       text: 'Created'
    //   }, {
    //       id: 'ID8',
    //       text: 'Updated'
    //   }, {
    //       id: 'ID9',
    //       text: 'Start date'
    //   }
    ];
    public getChildrens(id: string): any[] {
        let result: any[] = [];
        switch (id) {
            case 'ID1':
                result = [{id: '1', text: 'New'},
                          {id: '2', text: 'In process'},
                          {id: '0', text: 'Done'},
                          {id: '3', text: 'Resolve'},
                          {id: '4', text: 'Feedback'},
                          {id: '5', text: 'Closed'},
                          {id: '6', text: 'Rejected'}] ;
                break;
            case 'ID2':
                result = [{id: '1', text: 'Bug'},
                          {id: '2', text: 'Feature'},
                          {id: '3', text: 'Support'},
                          {id: '4', text: 'Task'} ] ;
                break;
            case 'ID3':
                result = [{id: '1', text: 'Low'},
                          {id: '2', text: 'Normal'},
                          {id: '3', text: 'High'},
                          {id: '4', text: 'Urgent'},
                          {id: '5', text: 'Medium'}] ;
                break;
            case 'ID4':
                result = [{ id: 'me', text: '<< me >>'},
                          { id: 'user1', text: 'User1'},
                          { id: 'user2', text: 'User2'}];
                break;
            default:
                break;
        }
        return result;
    }
    public getChild(id: string): any[] {
        let result: any[] = [];
        switch (id) {
            case 'ID1':
                result = [{ id: 'open', text: 'open'},
                          { id: 'is', text: 'is'},
                          { id: 'is not', text: 'is not'},
                          { id: 'closed', text: 'closed'},
                          { id: 'any', text: 'any'}];
                break;
            case 'ID2':
                result = [{ id: 'is', text: 'is'},
                          { id: 'is not', text: 'is not'}];
                break;
            case 'ID3':
                result = [{ id: 'is', text: 'is'},
                          { id: 'is not', text: 'is not'}];
                break;
            case 'ID4':
                result = [{ id: 'is', text: 'is'},
                          { id: 'is not', text: 'is not'},
                          { id: 'none', text: 'none'},
                          { id: 'any', text: 'any'}];
                break;
            case 'ID5':
                result = [{ id: 'contains', text: 'contains'},
                          { id: 'notcontain', text: 'doesn\'t contain'},
                          { id: 'none', text: 'none'},
                          { id: 'any', text: 'any'}];
                break;
            case 'ID6':
                result = [{ id: 'contains', text: 'contains'},
                          { id: 'notcontain', text: 'doesn\'t contain'},
                          { id: 'none', text: 'none'},
                          { id: 'any', text: 'any'}];
                break;
            case 'ID7':
                result = [{ id: 'is', text: 'is'},
                          { id: '>=', text: '>='},
                          { id: '<=', text: '<='},
                          { id: 'between', text: 'between'},
                          { id: 'less-than-days-a', text: 'less than day a'},
                          { id: 'amore-than-days', text: 'more than days'},
                          { id: 'in-the-past', text: 'in the past'},
                          { id: 'days-ago', text: 'days-ago'},
                          { id: 'today', text: 'today'},
                          { id: 'yesterday', text: 'yesterday'},
                          { id: 'this-week', text: 'this week'},
                          { id: 'none', text: 'none'}] ;
                break;
            case 'ID8':
                result = [{ id: 'is', text: 'is'},
                          { id: '>=', text: '>='},
                          { id: '<=', text: '<='},
                          { id: 'between', text: 'between'},
                          { id: 'less-than-days-a', text: 'less than day a'},
                          { id: 'amore-than-days', text: 'more than days'},
                          { id: 'in-the-past', text: 'in the past'},
                          { id: 'days-ago', text: 'days-ago'},
                          { id: 'today', text: 'today'},
                          { id: 'yesterday', text: 'yesterday'},
                          { id: 'this-week', text: 'this week'},
                          { id: 'none', text: 'none'}] ;
                break;
            case 'ID9':
                result = [{ id: 'is', text: 'is'},
                          { id: '>=', text: '>='},
                          { id: '<=', text: '<='},
                          { id: 'between', text: 'between'},
                          { id: 'less-than-days-a', text: 'less than day a'},
                          { id: 'amore-than-days', text: 'more than days'},
                          { id: 'in-the-past', text: 'in the past'},
                          { id: 'days-ago', text: 'days-ago'},
                          { id: 'today', text: 'today'},
                          { id: 'yesterday', text: 'yesterday'},
                          { id: 'this-week', text: 'this week'},
                          { id: 'none', text: 'none'}] ;
                break;
            default:
                break;
        }
        return result ;
    }
    public checkView(item: SearchEngine): any {
        const result: any = {};
            if ( item.child.id === 'open'
                || item.child.id === 'closed'
                || item.child.id === 'open'
                || item.child.id === 'any'
                || item.child.id === 'none') {
                    result.status = 0 ;
                    result.data = [] ;
            } else { if (    item.root.id === 'ID7'
                            || item.root.id === 'ID8'
                            || item.root.id === 'ID9') {
                                result.status = 3 ;
                                result.data = [] ;
                            } else if ( item.root.id === 'ID5'
                            || item.root.id === 'ID6') {
                                result.status = 2 ;
                                result.data = [] ;
                            } else {
                                result.status = 1 ;
                                result.data = this.getChildrens(item.root.id);
                            }
                        }
                        if ( item.child.id === 'between') {
                            result.status = 4 ;
                            result.data = [] ;
                        }
        return result ;
    }
}
