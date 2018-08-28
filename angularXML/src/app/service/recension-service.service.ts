import { Injectable } from '@angular/core';
import { Headers, Http } from '@angular/http';
import 'rxjs/add/operator/toPromise';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Recension } from '../model/recension';

@Injectable()
export class RecensionService {
    private baseUrl = 'http://localhost:8080/api/recension';

    constructor(private http: HttpClient) {
    }
    getAllArticleRecensions(id: Number): Observable<Recension[]>{
        return this.http.get<Recension[]>(this.baseUrl+`/article/${id}`)
    }

    getAllAuthorRecensions(username: String): Observable<Recension[]>{
        return this.http.get<Recension[]>(this.baseUrl+`/${username}`);
    }

    getRecension(id: Number): Observable<Recension>{
        return this.http.get<Recension>(this.baseUrl+`/${id}`);
    }
}