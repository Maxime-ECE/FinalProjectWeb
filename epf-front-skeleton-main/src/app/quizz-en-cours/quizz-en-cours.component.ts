import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'epf-quizz-en-cours',
  templateUrl: './quizz-en-cours.component.html',
  styleUrls: ['./quizz-en-cours.component.scss']
})
export class QuizzEnCours implements OnInit {
  selectedOption: string = '';

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  selectAnswer(option: string) {
    this.selectedOption = option;
  }

  checkAnswer() {
    if (this.selectedOption === 'Paris') {
      alert('Bonne réponse !');
    } else {
      alert('Mauvaise réponse. Veuillez réessayer.');
    }
  }

  nextQuestion() {
    this.router.navigate(['../']);
  }
}
