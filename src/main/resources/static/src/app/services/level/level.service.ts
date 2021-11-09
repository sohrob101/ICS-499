import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Level} from '../../models/level/level.model';

const baseUrl = 'http://localhost:8082/level';

@Injectable({
  providedIn: 'root'
})
export class LevelService {

  constructor(private http: HttpClient) { }

  getAll(): Observable<Level[]> {
    return this.http.get<Level[]>(baseUrl);
  }

  get(id: any): Observable<Level> {
    return this.http.get(`${baseUrl}/${id}`);
  }
  getHighScores(): Observable<any> {
    return this.http.get(baseUrl);
  }
}