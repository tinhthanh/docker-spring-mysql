export class UserAuth {
    private userName: String;
    private password: String;

    constructor($userName: String, $password: String) {
        this.userName = $userName;
        this.password = $password;
    }


    public get $userName(): String {
        return this.userName;
    }

    public set $userName(value: String) {
        this.userName = value;
    }

    public get $password(): String {
        return this.password;
    }

    public set $password(value: String) {
        this.password = value;
    }

}
