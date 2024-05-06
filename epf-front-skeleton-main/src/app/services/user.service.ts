import { Injectable } from "@angular/core"
import { Observable } from "rxjs"
import { HttpClient } from "@angular/common/http"
import { Users } from "../models/users.model"

@Injectable({
  providedIn: "root",
})
export class UserService {
  constructor(private http: HttpClient) {
  }

  private userURL = "http://localhost:8080/users"
  findAll(): Observable<Users[]> {
    return this.http.get<Users[]>(this.userURL)
  }
}

