import { Component, OnInit } from '@angular/core';
// import { MdDialog, MdDialogRef } from '@angular/material';

@Component({
  selector: 'app-confirmation-dialog',
  templateUrl: './confirmation-dialog.component.html',
  styleUrls: ['./confirmation-dialog.component.scss']
})
export class ConfirmationDialogComponent implements OnInit {

  constructor() { }

  public confirmMessage:string;
  ngOnInit(): void {
  }

  Delete(){
    
  }

}



