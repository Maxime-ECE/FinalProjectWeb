import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router"
import { QuizzService } from "../services/quizz.service"
import { HttpClient } from "@angular/common/http"

@Component({
  selector: 'epf-create-with-existing-quiz',
  templateUrl: './create-with-existing-quiz.component.html',
  styleUrls: ['./create-with-existing-quiz.component.scss']
})
export class CreateWithExistingQuizComponent implements OnInit {
  quizz: any = {}; // Utilisez un type approprié pour vos objets quizz

  constructor(private router: Router, private quizzService: QuizzService, private http: HttpClient) { }

  ngOnInit(): void {
    this.quizzService.getQuizTitleQuestionsAndAnswersWithId().subscribe(data => {
      this.quizz = data;
      console.log(data);
    });
  }


}
