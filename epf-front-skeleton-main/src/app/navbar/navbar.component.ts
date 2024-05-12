import { Component, OnInit } from "@angular/core"
import { Link } from "models/links.model"

@Component({
  selector: "epf-navbar",
  templateUrl: "./navbar.component.html",
  styleUrls: ["./navbar.component.scss"],
})
export class NavbarComponent {
  links: Link[] = []

  constructor() {
    this.links.push({ name: "Accueil", href: "" })
    this.links.push({ name: "Classement", href: "classement" })
    this.links.push({ name: "Créer", href: "creer" })
    this.links.push({ name: "Connexion", href: "connexion" })
  }
}
