import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-proyects',
  templateUrl: './proyects.component.html',
  styleUrls: ['./proyects.component.css']
})
export class ProyectsComponent implements OnInit {
  proyectsList:any;
  constructor(private getDatosPortfolio:PortfolioService) { }

  ngOnInit(): void {
    this.getDatosPortfolio.GetbyUserId().subscribe(data=>{
      this.proyectsList=data.proyect;
    });
  }
}
