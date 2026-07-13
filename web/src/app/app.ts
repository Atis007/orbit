import { HttpClient } from '@angular/common/http';
import { Component, inject, OnInit, signal } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.html',
  styleUrl: './app.css',
})
export class App implements OnInit {
  private http = inject(HttpClient);
  status = signal<string | null>(null);
  dbCheck = signal<number | null>(null);

  ngOnInit() {
    this.http
      .get<{ status: string; dbCheck: number }>('http://localhost:8080/api/ping')
      .subscribe((response) => {
        this.status.set(response.status);
        this.dbCheck.set(response.dbCheck);
      });
  }

  protected readonly title = signal('web');
}
