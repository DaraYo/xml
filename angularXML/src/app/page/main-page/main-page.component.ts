import { Component, OnInit } from '@angular/core';
import { AuthenticationService } from '../../service/authentication-service.service';
import { Router } from '@angular/router';
import { Article } from '../../model/article';
import { User } from '../../model/user';
import * as $ from 'jquery';
import { GlobalsService } from '../../service/globals.service';
import { NgbModal } from '../../../../node_modules/@ng-bootstrap/ng-bootstrap';
import { ArticleService } from '../../service/article-service.service';
import {NgbDateStruct, NgbCalendar} from '@ng-bootstrap/ng-bootstrap';
declare let Xonomy: any;

@Component({
  selector: 'app-main-page',
  templateUrl: './main-page.component.html',
  styleUrls: ['./main-page.component.css']
})

export class MainPageComponent implements OnInit {

  constructor(private articleService: ArticleService, private authenticationService: AuthenticationService,private router: Router, private global: GlobalsService, private modalService: NgbModal) { }

  private article;
  show: Boolean= false;
  login: Boolean;
  role: string;
  value: Boolean;
  name:string;
  pass:string;
  works: Article[]= [];
  myworks: Article[]= [];
  aworks: Article[]=[];
  dworks: Article[]=[];
  pworks: Article[]=[];
  currentUser: any;
  m: any;
  datepickerModel;

  ngOnInit() {
    //this.getAcceptedWorks();
    //$(document).ready(function(){
    if(localStorage.getItem('currentUser')){
      this.login= false;
      this.role= JSON.parse(localStorage.getItem('currentUser')).roles;
      console.log(this.role);
    }
    else{
      this.login= true;
    }
    //this.article="<naucniRad xmlns=\"http://www.ftn.uns.ac.rs/naucniRad\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"></naucniRad>";
    //let editor=document.getElementById("editor");
    //Xonomy.render(this.article, editor, this.global.docSpec);
    //$(document).ready(function(){
     // alert("njak");
   // });
  }

  getAcceptedWorks(){
    this.articleService.getAcceptedArticles().subscribe(data=>this.works=data);
  }
  

  loginUser(): void {
    alert("ekekek");
    this.authenticationService.login(this.name, this.pass).subscribe(
      (loggedIn: boolean) => {
        this.currentUser = JSON.parse(localStorage.getItem('currentUser'));
        if (loggedIn) {
          this.login= false;
          if(this.currentUser.roles=='Admin')
          {
            this.router.navigate(['/admin']);
            //this.login.emit(true);
          }
          if(this.currentUser.roles=='Editor')
          {
            this.router.navigate(['/editor']);
            //this.login.emit(true);
          }
          if(this.currentUser.roles=='Reviewer')
          {
            this.router.navigate(['/reviewer']);
            //this.login.emit(true);
          }
          if(this.currentUser.roles=='Author')
          {
            this.router.navigate(['/author']);
            //this.login.emit(true);
          }
        }
      }
    );
  }

  delete(id){
    this.articleService.removePendingArticle(id).subscribe(
      //this.articleService.getPen
    );
  }

  logoutForm()
  {
    this.authenticationService.logout();
    this.login= true;
  }

  showing(value) {
    this.value= value;
    if(value){
      this.m.close();
      this.login= false;
      this.router.navigate(['/admin']);
    }
    console.log("radi ngTemplate");
    
  }

  loginForm(content): void{
    this.show= true;
    this.m = this.modalService.open(content);
  }

  function(){
    console.log("jes");
  }

  start(){
    alert("jej");
    //var xml="<list><item label='one'/><item label='two'/></list>";
    //var editor=document.getElementById("editor");
    //Xonomy.render(xml, editor, null);
  }

  posaljiRad(){}

}
