import {Component, ElementRef, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from '@angular/material/paginator';
import {Sort} from '@angular/material/sort';

import {MatTableDataSource} from "@angular/material/table";
import {BehaviorSubject} from 'rxjs';
import {Score} from '../../models/score-list/score.model';
import {ScoreService} from '../../services/score-list/score.service';


@Component({
  selector: 'app-score-list',
  templateUrl: './score-list.component.html',
  styleUrls: ['./score-list.component.css']
})
export class ScoreListComponent implements OnInit {

  // columns we will show on the table
  public displayedColumns = ['Rank', 'Username', 'Score'];
  //the source where we will get the data
  public dataSource = new MatTableDataSource<Score>();

  public scoreList?: Score[];

  private loadingSubject = new BehaviorSubject<boolean>(false);

  public loading$ = this.loadingSubject.asObservable();

  @ViewChild(MatPaginator) paginator: MatPaginator;

  @ViewChild('input') input: ElementRef;


  constructor(private scoreervice: ScoreService) { }


  ngOnInit() {
    this.retrievescore();
  }
  retrievescore() {

    this.scoreervice.getHighScores()
      .subscribe((res) => {
        res.forEach(data => {
          data.playerRank = res.indexOf(data) + 1
        });
        this.dataSource = new MatTableDataSource(res);
        this.dataSource.paginator = this.paginator;

      }),
      (error: any) => {
        console.error(error);
      };
  }


  sortData(sort: Sort) {
    // Sort sorts the current list, but it wasnt updating it unless i reassigned.
    this.dataSource.data = this.dataSource.data.sort((a, b) => {

      const isAsc = sort.direction === 'asc';

      if (sort.active == "Score") {

        return this._compare(a.bestScore!, b.bestScore!, isAsc);
      }

      else if (sort.active == "Username") {

        return this._compare(a.userName!, b.userName!, isAsc);

      } else if (sort.active == "Rank") {

        return this._compare(a.playerRank, b.playerRank, isAsc);

      }
      else {
        return 1;
      }

    });
  }
  private _compare(a: string, b: string, isAsc: boolean) {
    return (a < b ? -1 : 1) * (isAsc ? 1 : -1);
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }


  
}