import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Article } from '../model/article';
import { AuthenticationService } from './authentication-service.service';

@Injectable()
export class ArticleService {
    private baseUrl = 'http://localhost:8080/articles';
    private headers: HttpHeaders;

    constructor(private http: HttpClient, private auth: AuthenticationService ) {
        this.headers = new HttpHeaders({ 'Content-Type': 'application/xml'});
        this.headers.append("Authorization", auth.getToken().toString());
    }

    getAllArticles(): Observable<Article[]>{
        return this.http.get<Article[]>(this.baseUrl);
    }

    getAcceptedArticles(): Observable<Article[]>{
        return this.http.get<Article[]>(this.baseUrl);
    }

    getAllAuthorArticles(username: String): Observable<Article[]>{
        return this.http.get<Article[]>(this.baseUrl+`/${username}`);
    }

    getArticle(id: Number): Observable<Article>{
        return this.http.get<Article>(this.baseUrl+`/${id}`);
    }

    removePendingArticle(id: string){
        return this.http.put(this.baseUrl+'/article', id);
    }

    addArticle(article: string){
        return this.http.post(this.baseUrl, article, {headers: this.headers});
    }
}