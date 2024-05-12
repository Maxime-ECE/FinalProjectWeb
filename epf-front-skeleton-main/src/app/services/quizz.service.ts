import { Injectable } from "@angular/core"
import { Observable } from "rxjs"
import { HttpClient } from "@angular/common/http"
import { Users } from "../models/users.model"
import { QuizzModel } from "../models/quizz.model"

@Injectable({
  providedIn: "root",
})
export class QuizzService {
  constructor(private http: HttpClient) {
  }

  private userURL = "http://localhost:8080/quizz"
  private apiUrl :string =  "http://localhost:8080"
  findAll(): Observable<QuizzModel[]> {
    return this.http.get<QuizzModel[]>(this.userURL)
  }
  getQuizzWithQuestionsAndAnswers(): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/quizz/title-and-questions-ANSWERS`);
  }
}

