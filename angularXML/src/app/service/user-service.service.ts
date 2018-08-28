import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { User } from '../model/user';

@Injectable()
export class UserService {
  private baseUrl = 'http://localhost:8080/api/user';

  constructor(private http: HttpClient) {
  }

  getUsers(role:string): Observable<User[]>{
    return this.http.get<User[]>('http://localhost:8080/usersByRole/'+`${role}`);
  }
  getLoggedIn(): Observable<User>{
    return this.http.get<User>(this.baseUrl);
  }
  registerUser(user:User)
  {
    return this.http.post('http://localhost:8080/register',user);
  }
}