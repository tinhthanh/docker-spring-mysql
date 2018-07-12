
export class GruopContact {
    group_contact_id: number ;
    group_contact_name: string;
    user_id: string;
    group_contact_status: string ;
    status: number;
    constructor(group_contact_id: number,
        group_contact_name: string,
        user_id?: string,
        group_contact_status?: string ,
        status?: number) {
            this.group_contact_id = group_contact_id;
            this.group_contact_name = group_contact_name;
            this.user_id = user_id;
            this.group_contact_status = group_contact_status;
            this.status = status;

    }
}
