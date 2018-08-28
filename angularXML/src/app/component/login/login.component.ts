import { Component, OnInit,Output ,EventEmitter} from '@angular/core';
import { AuthenticationService } from '../../service/authentication-service.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  name:string;
  password:string;

  @Output() login=new EventEmitter<boolean>();
  constructor(private authenticationService: AuthenticationService,private router: Router) { }

  ngOnInit() {
  }

  loginUser(): void {
    alert("alaalalla");
    this.authenticationService.login(this.name, this.password).subscribe(
      (loggedIn: boolean) => {
        alert('je li moguce da dalje nista ne odradi');
        var currentUser = JSON.parse(localStorage.getItem('currentUser'));
        if (loggedIn) {
          alert("treba da budes u else-u");
          if(currentUser.roles=='admin')
          {
            //this.router.navigate(['/admin']);
            this.login.emit(true);
          }
          else{
            //this.router.navigate(['/author']);
            this.login.emit(false);
          }
        }
        else
        {
          console.log('pf');
          alert("neee");
        }
      }
    );
  }
}
