import { Component, OnInit } from '@angular/core';
import { CourseService } from "../services/course.service"
import { Course } from "../models/course.model"
import { Users } from "../models/users.model"
import { UserService } from "../services/user.service"

@Component({
  selector: 'epf-classement',
  templateUrl: './classement.component.html',
  styleUrls: ['./classement.component.scss']
})
export class ClassementComponent implements OnInit {
  constructor(private userService: UserService) { }

  aaa: Users[] = [];
  ngOnInit(): void {
    this.userService.findAll().subscribe(tableau => this.aaa = tableau);
  }

}
