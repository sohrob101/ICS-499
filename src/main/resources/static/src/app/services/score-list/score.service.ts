import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Score} from '../../models/score-list/score.model';

const baseUrl = 'http://localhost:8082/player/highscores';

@Injectable({
  providedIn: 'root'
})
export class ScoreService {

  constructor(private http: HttpClient) { }

  getHighScores(): Observable<Score[]> {
    return this.http.get<Score[]>(baseUrl);
  }
}