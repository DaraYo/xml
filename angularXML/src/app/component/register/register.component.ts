import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user';
import { UserService } from '../../service/user-service.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  newUser :User= new User();

  constructor(private userService: UserService) { }

  ngOnInit() {
  }
  register()
  {
    console.log(this.newUser);
    this.userService.registerUser(this.newUser).subscribe();
  }
}
