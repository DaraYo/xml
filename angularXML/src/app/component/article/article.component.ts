import { Component, OnInit,Input } from '@angular/core';
import { ArticleService } from '../../service/article-service.service';
import { Article } from '../../model/article';
import { Review } from '../../model/review';
import { Recension } from '../../model/recension';
import { ReviewService } from '../../service/review-service.service';
import { RecensionService } from '../../service/recension-service.service';
import { GlobalsService } from '../../service/globals.service';
import * as $ from 'jquery';

declare let Xonomy: any;
@Component({
  selector: 'app-article',
  templateUrl: './article.component.html',
  styleUrls: ['./article.component.css']
})
export class ArticleComponent implements OnInit {

  constructor(private articleService: ArticleService,private reviewService: ReviewService, private global: GlobalsService, private recensionService: RecensionService) { }
  @Input() article:Article;
  reviews: Review[];
  recensions: Recension[];
  private art;
  login: Boolean;
  ngOnInit() {
    //this.reviewService.getAllArticleRecensions(this.article.id).subscribe(data=>this.reviews=data);
    //this.recensionService.getAllArticleRecensions(this.article.id).subscribe(data=>this.recensions=data);
    if(localStorage.getItem('currentUser')){
      this.login= false;
    }
    this.art="<naucniRad xmlns=\"http://www.ftn.uns.ac.rs/naucniRad\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"></naucniRad>";
    let editor=document.getElementById("editor");
    Xonomy.render(this.art, editor, this.global.article);
    $(document).ready(function(){
     // alert("pf");
    });
  }

  getData(event){
    let input = event.target;
    for (var index = 0; index < input.files.length; index++) {
        let reader = new FileReader();
        reader.onload = () => {
            // this 'text' is the content of the file
            var text = reader.result;
            let editor1 = document.getElementById("editor");
            this.art = text;
            console.log("jeesss");
            console.log(this.art);
            Xonomy.render(this.art, editor1, this.global.article);
        }
        reader.readAsText(input.files[index]);
    }; 

  }

  addArticle(){
    alert("aaaaaaaaaaaaa");
    console.log(JSON.stringify(this.art));
    this.articleService.addArticle(this.art).subscribe();
  }
}
