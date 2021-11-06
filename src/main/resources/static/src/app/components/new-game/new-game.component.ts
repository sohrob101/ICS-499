import { Component, OnInit } from '@angular/core';
import { MatGridListModule } from '@angular/material/grid-list';
import { Grid } from 'src/app/models/grid/grid.model';
import { Point } from 'src/app/models/point/point.model';
import { LinePuzzle } from '../../models/line-puzzle/line-puzlle.model';
import { NewGameService } from '../../services/new-game/new-game.service';

@Component({
  selector: 'app-new-game',
  templateUrl: './new-game.component.html',
  styleUrls: ['./new-game.component.css']
})
export class NewGameComponent implements OnInit {

  newVertexes?: Array<Array<Point>>;

  // gridSize?: number;



  constructor(private newGameService: NewGameService) { }


  ngOnInit(): void {
    this.retrieveGame();
  }


  retrieveGame(): void {


    this.newGameService.getNewGame().forEach(element => {
     

        this.newVertexes =  element.mainGrid?.vertexes;
    
    

    });
  }
}

  // retrieveGame(): void {


  //   this.newGameService.getNewGame().forEach(element => {
  //     element.mainGrid?.vertexes?.forEach(element2 => {
  //       console.log(element2)
  //     })

  //   });
  // }



