import { Component, OnInit,Output,EventEmitter } from '@angular/core';
import { UserService } from '../../service/user-service.service';
import { User } from '../../model/user';
import { AuthenticationService } from '../../service/authentication-service.service';

@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

  constructor(private userService : UserService,private authenticationService: AuthenticationService) { }

  ngOnInit() {
    //this.getLoggedUser();
  }
  
  user:User = new User();
  @Output() logout=new EventEmitter<boolean>();
  getLoggedUser(){
    this.userService.getLoggedIn().subscribe(res=>this.user=res);
  }
  logoutUser()
  {
    this.authenticationService.logout()
    this.logout.emit(false);
  }
}
