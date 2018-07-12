export class Role {
     roleId: number;
     roleName: String;

    constructor($roleId: number, $roleName: String) {
        this.roleId = $roleId;
        this.roleName = $roleName;
    }

    public get $roleId(): number {
        return this.roleId;
    }

    public set $roleId(value: number) {
        this.roleId = value;
    }

    public get $roleName(): String {
        return this.roleName;
    }

    public set $roleName(value: String) {
        this.roleName = value;
    }


}
