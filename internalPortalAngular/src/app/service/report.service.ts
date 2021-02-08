import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ReportService {

  constructor(private http: HttpClient) { }

  DELETE_REPORT = '/report'
  public deleteReport(id: Number): Observable<any> {
    return this.http.delete(this.DELETE_REPORT + '/' + id);
  }

}