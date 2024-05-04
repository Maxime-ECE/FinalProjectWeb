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
  findAll(): Observable<QuizzModel[]> {
    return this.http.get<QuizzModel[]>(this.userURL)
  }
}

