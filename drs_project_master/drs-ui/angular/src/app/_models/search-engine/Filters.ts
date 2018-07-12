import { SearchEngine } from './SearchEngine';


export class Filters {
    selectItem: SearchEngine[];
    constructor(selectItem: SearchEngine[]) {
        this.selectItem = selectItem;
    }
    public getFilters(): string  {
        let result = '';
        this.selectItem.forEach( (item ) => {
            if ( item.childrens ) {
                result += `&${this.parameter(item.root.id)}=${item.childrens[0].id}`;
            }
        });
        return result ;
    }
    public parameter(key: string): string {
        let result = '';
        switch (key) {
            case 'ID1':
                result =  'status_id';
                break;
            case 'ID2':
                result =  'tracker_id';
                break;
            case 'ID3':
                result =  'priority_id';
                break;
            case 'ID4':
                result =  'assigned_to_id';
                break;
            default:
                break;
        }
        return result;
    }
}
