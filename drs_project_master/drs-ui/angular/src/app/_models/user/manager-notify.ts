import { NotifyContent } from './notify-content';
import { NotifyCenter } from '../notify/notify-center';

export class ManagerNotify {
    listNotity: NotifyContent[] = [];
    constructor() {
    }
    public addNotify(notify: NotifyContent) {
        this.listNotity.push(notify);
    }
    public removeNotify(id: number ) {
        this.listNotity.forEach( (res: NotifyContent, index) => {
            if (res.id === id ) {
                this.listNotity.splice(index , 1 );
            }
        });
    }
}
