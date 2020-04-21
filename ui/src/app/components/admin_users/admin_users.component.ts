import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/user/service/user.service';

@Component({
  selector: 'app-admin-users',
  templateUrl: './admin_users.component.html',
  styleUrls: ['./admin_users.component.css'],
})
export class AdminUsersComponent implements OnInit {
  public users;
  displayedColumns: string[] = [
    'user_id',
    'username',
    'email',
    'createdAt',
    'actions',
  ];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.getUsers();
  }

  getUsers() {
    this.userService.getUsers().subscribe(
      (data) => {
        this.users = data;
      },
      (err) => console.error(err),
      () => console.log('users loaded')
    );
  }
}
