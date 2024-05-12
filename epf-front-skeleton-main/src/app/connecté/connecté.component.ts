import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';


@Component({
  selector: 'epf-connecté',
  templateUrl: './connecté.component.html',
  styleUrls: ['./connecté.component.scss']
})
export class Connecté implements OnInit {
  username: string | null = '';

  constructor(private route: ActivatedRoute) { }

  ngOnInit(): void {
    // Récupérer le nom d'utilisateur de la route
    this.username = this.route.snapshot.paramMap.get('username');
  }

}
