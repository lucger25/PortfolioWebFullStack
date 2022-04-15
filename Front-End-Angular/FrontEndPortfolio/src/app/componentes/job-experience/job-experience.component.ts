import { Component, OnInit } from '@angular/core';
import { PortfolioService } from 'src/app/services/portfolio.service';

@Component({
  selector: 'app-job-experience',
  templateUrl: './job-experience.component.html',
  styleUrls: ['./job-experience.component.css']
})
export class JobExperienceComponent implements OnInit {

  constructor(private getDatosPortfolio:PortfolioService) { }

  ngOnInit(): void {
  }

}
