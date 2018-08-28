import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../service/authentication-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-user-page',
  templateUrl: './user-page.component.html',
  styleUrls: ['./user-page.component.css']
})
export class UserPageComponent implements OnInit {

  constructor(private authentication :AuthenticationService,private router: Router) { }
  loggedIn:boolean=false;
  ngOnInit() {
    this.loggedIn=this.authentication.isLoggedIn()
    
  }
  
  log(value)
  {
    if(value)
    {
      this.loggedIn=true;
    }
    else{
      this.loggedIn=false;
    }
  }

  editorPage()
  {
    this.router.navigate(['/editor']);
  }

  reviewerPage()
  {
    this.router.navigate(['/reviewer']);
  }
  authorPage()
  {
    this.router.navigate(['/author']);
  }
}
