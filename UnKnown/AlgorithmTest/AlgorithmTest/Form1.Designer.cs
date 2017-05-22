namespace AlgorithmTest
{
    partial class Form1
    {
        /// <summary>
        /// 필수 디자이너 변수입니다.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// 사용 중인 모든 리소스를 정리합니다.
        /// </summary>
        /// <param name="disposing">관리되는 리소스를 삭제해야 하면 true이고, 그렇지 않으면 false입니다.</param>
        protected override void Dispose( bool disposing )
        {
            if ( disposing && ( components != null ) )
            {
                components.Dispose();
            }
            base.Dispose( disposing );
        }

        #region Windows Form 디자이너에서 생성한 코드

        /// <summary>
        /// 디자이너 지원에 필요한 메서드입니다. 
        /// 이 메서드의 내용을 코드 편집기로 수정하지 마세요.
        /// </summary>
        private void InitializeComponent()
        {
            System.Windows.Forms.DataVisualization.Charting.ChartArea chartArea1 = new System.Windows.Forms.DataVisualization.Charting.ChartArea();
            System.Windows.Forms.DataVisualization.Charting.Legend legend1 = new System.Windows.Forms.DataVisualization.Charting.Legend();
            System.Windows.Forms.DataVisualization.Charting.Series series1 = new System.Windows.Forms.DataVisualization.Charting.Series();
            this.processChart = new System.Windows.Forms.DataVisualization.Charting.Chart();
            this.dataProcess = new System.Windows.Forms.DataGridView();
            this.btnRun = new System.Windows.Forms.Button();
            this.tbProcess = new System.Windows.Forms.TextBox();
            this.btnFCFS = new System.Windows.Forms.Button();
            this.btnSJF = new System.Windows.Forms.Button();
            this.btnSRT = new System.Windows.Forms.Button();
            this.btnHRN = new System.Windows.Forms.Button();
            this.btnPrio = new System.Windows.Forms.Button();
            this.btnRRB = new System.Windows.Forms.Button();
            ((System.ComponentModel.ISupportInitialize)(this.processChart)).BeginInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataProcess)).BeginInit();
            this.SuspendLayout();
            // 
            // processChart
            // 
            chartArea1.Name = "ChartArea1";
            this.processChart.ChartAreas.Add(chartArea1);
            legend1.Alignment = System.Drawing.StringAlignment.Center;
            legend1.Docking = System.Windows.Forms.DataVisualization.Charting.Docking.Bottom;
            legend1.Name = "Process";
            this.processChart.Legends.Add(legend1);
            this.processChart.Location = new System.Drawing.Point(10, 43);
            this.processChart.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.processChart.Name = "processChart";
            series1.ChartArea = "ChartArea1";
            series1.ChartType = System.Windows.Forms.DataVisualization.Charting.SeriesChartType.Bar;
            series1.Legend = "Process";
            series1.Name = "Process";
            this.processChart.Series.Add(series1);
            this.processChart.Size = new System.Drawing.Size(780, 246);
            this.processChart.TabIndex = 0;
            // 
            // dataProcess
            // 
            this.dataProcess.AllowUserToAddRows = false;
            this.dataProcess.AllowUserToDeleteRows = false;
            this.dataProcess.AutoSizeColumnsMode = System.Windows.Forms.DataGridViewAutoSizeColumnsMode.Fill;
            this.dataProcess.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataProcess.Location = new System.Drawing.Point(10, 294);
            this.dataProcess.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.dataProcess.Name = "dataProcess";
            this.dataProcess.ReadOnly = true;
            this.dataProcess.RowTemplate.Height = 27;
            this.dataProcess.Size = new System.Drawing.Size(780, 216);
            this.dataProcess.TabIndex = 1;
            // 
            // btnRun
            // 
            this.btnRun.Location = new System.Drawing.Point(165, 6);
            this.btnRun.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnRun.Name = "btnRun";
            this.btnRun.Size = new System.Drawing.Size(108, 29);
            this.btnRun.TabIndex = 2;
            this.btnRun.Text = "Run";
            this.btnRun.UseVisualStyleBackColor = true;
            this.btnRun.Click += new System.EventHandler(this.btnRun_Click);
            // 
            // tbProcess
            // 
            this.tbProcess.Location = new System.Drawing.Point(52, 10);
            this.tbProcess.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.tbProcess.Name = "tbProcess";
            this.tbProcess.Size = new System.Drawing.Size(109, 21);
            this.tbProcess.TabIndex = 3;
            // 
            // btnFCFS
            // 
            this.btnFCFS.Location = new System.Drawing.Point(287, 6);
            this.btnFCFS.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnFCFS.Name = "btnFCFS";
            this.btnFCFS.Size = new System.Drawing.Size(78, 28);
            this.btnFCFS.TabIndex = 4;
            this.btnFCFS.Text = "FCFS";
            this.btnFCFS.UseVisualStyleBackColor = true;
            this.btnFCFS.Click += new System.EventHandler(this.btnFCFS_Click);
            // 
            // btnSJF
            // 
            this.btnSJF.Location = new System.Drawing.Point(370, 6);
            this.btnSJF.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnSJF.Name = "btnSJF";
            this.btnSJF.Size = new System.Drawing.Size(78, 28);
            this.btnSJF.TabIndex = 5;
            this.btnSJF.Text = "SJF";
            this.btnSJF.UseVisualStyleBackColor = true;
            this.btnSJF.Click += new System.EventHandler(this.btnSJF_Click);
            // 
            // btnSRT
            // 
            this.btnSRT.Location = new System.Drawing.Point(453, 6);
            this.btnSRT.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnSRT.Name = "btnSRT";
            this.btnSRT.Size = new System.Drawing.Size(78, 28);
            this.btnSRT.TabIndex = 6;
            this.btnSRT.Text = "SRT";
            this.btnSRT.UseVisualStyleBackColor = true;
            this.btnSRT.Click += new System.EventHandler(this.btnSRT_Click);
            // 
            // btnHRN
            // 
            this.btnHRN.Location = new System.Drawing.Point(536, 6);
            this.btnHRN.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnHRN.Name = "btnHRN";
            this.btnHRN.Size = new System.Drawing.Size(78, 28);
            this.btnHRN.TabIndex = 7;
            this.btnHRN.Text = "HRN";
            this.btnHRN.UseVisualStyleBackColor = true;
            this.btnHRN.Click += new System.EventHandler(this.btnHRN_Click);
            // 
            // btnPrio
            // 
            this.btnPrio.Location = new System.Drawing.Point(620, 6);
            this.btnPrio.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnPrio.Name = "btnPrio";
            this.btnPrio.Size = new System.Drawing.Size(78, 28);
            this.btnPrio.TabIndex = 8;
            this.btnPrio.Text = "Priority";
            this.btnPrio.UseVisualStyleBackColor = true;
            this.btnPrio.Click += new System.EventHandler(this.btnPrio_Click);
            // 
            // btnRRB
            // 
            this.btnRRB.Location = new System.Drawing.Point(703, 6);
            this.btnRRB.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.btnRRB.Name = "btnRRB";
            this.btnRRB.Size = new System.Drawing.Size(78, 28);
            this.btnRRB.TabIndex = 9;
            this.btnRRB.Text = "RRB";
            this.btnRRB.UseVisualStyleBackColor = true;
            this.btnRRB.Click += new System.EventHandler(this.btnRRB_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 12F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.AutoSizeMode = System.Windows.Forms.AutoSizeMode.GrowAndShrink;
            this.ClientSize = new System.Drawing.Size(802, 519);
            this.Controls.Add(this.btnRRB);
            this.Controls.Add(this.btnPrio);
            this.Controls.Add(this.btnHRN);
            this.Controls.Add(this.btnSRT);
            this.Controls.Add(this.btnSJF);
            this.Controls.Add(this.btnFCFS);
            this.Controls.Add(this.tbProcess);
            this.Controls.Add(this.btnRun);
            this.Controls.Add(this.dataProcess);
            this.Controls.Add(this.processChart);
            this.Margin = new System.Windows.Forms.Padding(3, 2, 3, 2);
            this.Name = "Form1";
            this.Text = "Algorithm Test";
            ((System.ComponentModel.ISupportInitialize)(this.processChart)).EndInit();
            ((System.ComponentModel.ISupportInitialize)(this.dataProcess)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.DataVisualization.Charting.Chart processChart;
        private System.Windows.Forms.DataGridView dataProcess;
        private System.Windows.Forms.Button btnRun;
        private System.Windows.Forms.TextBox tbProcess;
        private System.Windows.Forms.Button btnFCFS;
        private System.Windows.Forms.Button btnSJF;
        private System.Windows.Forms.Button btnSRT;
        private System.Windows.Forms.Button btnHRN;
        private System.Windows.Forms.Button btnPrio;
        private System.Windows.Forms.Button btnRRB;
    }
}

