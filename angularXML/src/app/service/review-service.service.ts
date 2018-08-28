import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Review } from '../model/review';

@Injectable()
export class ReviewService {
    private baseUrl = 'http://localhost:8080/api/review';

    constructor(private http: HttpClient) {
    }
    getAllArticleRecensions(id: Number): Observable<Review[]>{
        return this.http.get<Review[]>(this.baseUrl+`/article/${id}`)
    }

    getAllAuthorRecensions(username: String): Observable<Review[]>{
        return this.http.get<Review[]>(this.baseUrl+`/${username}`);
    }

    getRecension(id: Number): Observable<Review>{
        return this.http.get<Review>(this.baseUrl+`/${id}`);
    }
}