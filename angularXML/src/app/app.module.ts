import { BrowserModule } from '@angular/platform-browser';
import { NgModule, NO_ERRORS_SCHEMA } from '@angular/core';

import { RouterModule, Routes } from '@angular/router';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import { NgbModal, NgbModule } from '@ng-bootstrap/ng-bootstrap';
//services
import { JwtUtilsService } from './service/jwt-utils.service';
import { AuthenticationService } from './service/authentication-service.service';
import { TokenInterceptorService } from './service/token-intercepter.service';
import { ArticleService } from './service/article-service.service';
import { GlobalsService } from './service/globals.service';
import { ReviewService } from './service/review-service.service';
//components
import { AppComponent } from './app.component';
import { UserPageComponent } from './page/user-page/user-page.component';
import { LoginComponent } from './component/login/login.component';
import { AdminComponent } from './component/admin/admin.component';
import { UserService } from './service/user-service.service';
import { UserComponent } from './component/user/user.component';
import { RegisterComponent } from './component/register/register.component';
import { AuthorComponent } from './component/author/author.component';
import { ReviewerComponent } from './component/reviewer/reviewer.component';
import { EditorComponent } from './component/editor/editor.component';
import { ArticleComponent } from './component/article/article.component';
import { MainPageComponent } from './page/main-page/main-page.component';
import { RecensionService } from './service/recension-service.service';

const appRoutes: Routes = 
[
  {
    path:'userpage',component:UserPageComponent
  },
  {
    path:'mainpage',component:MainPageComponent
  },
  {
    path:'admin',component:AdminComponent
  },
  {
    path:'author',component:AuthorComponent
  },
  {
    path:'reviewer',component:ReviewerComponent
  },
  {
    path:'editor',component:EditorComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    UserPageComponent,
    LoginComponent,
    AdminComponent,
    UserComponent,
    RegisterComponent,
    AuthorComponent,
    ReviewerComponent,
    EditorComponent,
    ArticleComponent,
    MainPageComponent
  ],
  imports: [
    NgbModule.forRoot(),
    BrowserModule,
    FormsModule,
    HttpModule,
    RouterModule.forRoot(
      appRoutes,
      { enableTracing: false } // <-- debugging purposes only
    ),
    HttpClientModule
  ],
  providers: [ 
    AuthenticationService,
    JwtUtilsService,
    UserService,
    GlobalsService,
    ArticleService,
    ReviewService,
    RecensionService,
  {
    provide: HTTP_INTERCEPTORS,
    useClass: TokenInterceptorService,
    multi: true
  }],
  bootstrap: [AppComponent]
})
export class AppModule { }
