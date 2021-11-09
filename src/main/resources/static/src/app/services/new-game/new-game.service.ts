import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {LinePuzzle} from 'src/app/models/line-puzzle/line-puzlle.model';


const baseUrl = 'http://localhost:8082/game/newGame';

@Injectable({
  providedIn: 'root'
})
export class NewGameService {

  constructor(private http: HttpClient) { }

  getNewGame(): Observable<LinePuzzle> {
    return this.http.get<LinePuzzle>(baseUrl);
  }

}