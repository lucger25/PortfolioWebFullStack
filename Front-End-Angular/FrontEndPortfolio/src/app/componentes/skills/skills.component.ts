import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-skills',
  templateUrl: './skills.component.html',
  styleUrls: ['./skills.component.css']
})
export class SkillsComponent implements OnInit {
  skillList:any;
  constructor(private getDatosPortfolio:PortfolioService) { }

  ngOnInit(): void {
    this.getDatosPortfolio.GetbyUserId().subscribe(data=>{
      this.skillList=data.skill;
    });
  }

}
