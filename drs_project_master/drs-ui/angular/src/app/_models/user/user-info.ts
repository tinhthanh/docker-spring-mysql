import { Role } from './role';
export class UserInfo {
     userId: number;
     userName: string;
     email: string;
     lastPasswordChange: Date;
     fullName: string;
     permission: Array<Role>;


    constructor($userName: string, $email: string, $lastPasswordChange: Date, $fullName: string, $permission: Array<Role>) {
        this.userName = $userName;
        this.email = $email;
        this.lastPasswordChange = $lastPasswordChange;
        this.fullName = $fullName;
        this.permission = $permission;
    }

    public get $userName(): string {
        return this.userName;
    }

    public set $userName(value: string) {
        this.userName = value;
    }

    public get $email(): string {
        return this.email;
    }

    public set $email(value: string) {
        this.email = value;
    }

    public get $lastPasswordChange(): Date {
        return this.lastPasswordChange;
    }

    public set $lastPasswordChange(value: Date) {
        this.lastPasswordChange = value;
    }

    public get $fullName(): string {
        return this.fullName;
    }

    public set $fullName(value: string) {
        this.fullName = value;
    }

    public get $permission(): Array<Role> {
        return this.permission;
    }

    public set $permission(value: Array<Role>) {
        this.permission = value;
    }

}
