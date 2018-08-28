import { Component, OnInit } from '@angular/core';
import { Article } from '../../model/article';
import { ArticleService } from '../../service/article-service.service';

@Component({
  selector: 'app-author',
  templateUrl: './author.component.html',
  styleUrls: ['./author.component.css']
})
export class AuthorComponent implements OnInit {

  constructor(private articleService: ArticleService) { }
  articles:Article[];
  ngOnInit() {
    var currentUser = JSON.parse(localStorage.getItem('currentUser'));
    this.articleService.getAllAuthorArticles(currentUser.username).subscribe(data=>this.articles=data);
  }
}
