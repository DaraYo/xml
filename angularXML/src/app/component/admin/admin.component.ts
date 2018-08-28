import { Component, OnInit } from '@angular/core';
import { User } from '../../model/user';
import { UserService } from '../../service/user-service.service';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  constructor(private userService : UserService) { }

  ngOnInit() {
    this.fillTables();
  }
  authors: User[];
  reviewers: User[];
  editors: User[];

  fillTables()
  {
    this.userService.getUsers('Autor').subscribe(res => this.authors=res); 
    this.userService.getUsers('Reviewer').subscribe(res => this.reviewers=res); 
    this.userService.getUsers('Editor').subscribe(res => this.editors=res); 
  }
}
