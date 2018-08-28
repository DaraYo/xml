import { Component } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private router: Router)
  {

  }
  ngOnInit(){
    if(localStorage.getItem('currentUser')){
      let item2= JSON.parse(localStorage.getItem('currentUser')).roles;
      if(item2=="admin"){
        //this.router.navigate(['mainpage']);
        console.log('jej');
      }
    }
    //this.router.navigate(['mainpage']);
  }
}
