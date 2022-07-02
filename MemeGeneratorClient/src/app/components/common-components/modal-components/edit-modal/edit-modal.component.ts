import { Component, Inject, OnInit} from '@angular/core';
import { MatDialogRef, MAT_DIALOG_DATA } from '@angular/material/dialog';
import { editModalInterface } from 'src/app/models/interfaces';
import { CommonService } from 'src/app/services/common.service';

@Component({
  selector: 'app-edit-modal',
  templateUrl: './edit-modal.component.html',
  styleUrls: ['./edit-modal.component.scss']
})
export class EditModalComponent implements OnInit {

  public data: editModalInterface = {
    isEdit: false,
    constantCaption: false,
    constantImage: false
  }

  constructor(
    @Inject(MAT_DIALOG_DATA) data:  editModalInterface,
    private commonService: CommonService,
    private dialogRef: MatDialogRef<EditModalComponent>
  ) { 
    this.data = data
    this.commonService.componentLoading.next(false)
  }

  ngOnInit(): void {
  }
  
  closeDialog(): void {
    this.dialogRef.close(this.data)

  }
}
