import { UserInfo } from './user-info';
import { Role } from './role';

export class UserRoleList {
  total: number;
  listOfUser: UserSubInfo[];
}

export class UserSubInfo extends UserInfo {
  roles: Role[];
  userId: number;
}
