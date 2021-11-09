import {Component, OnInit} from '@angular/core';
import {Point} from 'src/app/models/point/point.model';
import {NewGameService} from '../../services/new-game/new-game.service';

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
        this.newVertexes = element.mainGrid?.vertexes;
        console.log(this.newVertexes);
    });
  }
}