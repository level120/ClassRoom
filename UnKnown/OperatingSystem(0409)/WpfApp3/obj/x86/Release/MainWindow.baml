   M S B A M L   `   `   `  ���� C  ?GanttWPF, Version=1.0.0.0, Culture=neutral, PublicKeyToken=nullM4clr-namespace:SCADAServis.Controls;assembly=GanttWPFSCADAServis.Controls  [ WSystem.Windows.Forms, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089Y@clr-namespace:System.Windows.Forms;assembly=System.Windows.FormsSystem.Windows.Forms m iSystem.Windows.Forms.DataVisualization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35�mclr-namespace:System.Windows.Forms.DataVisualization.Charting;assembly=System.Windows.Forms.DataVisualization/System.Windows.Forms.DataVisualization.Charting B >WpfApp3, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null!clr-namespace:WpfApp3WpfApp3 S OToggleSwitch, Version=1.1.2.0, Culture=neutral, PublicKeyToken=8637099990568f75A0clr-namespace:ToggleSwitch;assembly=ToggleSwitchToggleSwitch    WpfApp3.MainWindow   AControls4clr-namespace:SCADAServis.Controls;assembly=GanttWPF  \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35^ ZWindowsFormsIntegration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35U	 QWPFToolkit, Version=3.5.40128.1, Culture=neutral, PublicKeyToken=31bf3856ad364e35H 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     	 R
 NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml 
    @d2http://schemas.microsoft.com/expression/blend/2008 
    Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006 
    Owf@clr-namespace:System.Windows.Forms;assembly=System.Windows.Forms 
    �mschartmclr-namespace:System.Windows.Forms.DataVisualization.Charting;assembly=System.Windows.Forms.DataVisualization 
    'localclr-namespace:WpfApp3 
    IToggleSwitch0clr-namespace:ToggleSwitch;assembly=ToggleSwitch 
      � Title$&   CPU 스케쥴링 시뮬레이션��$	��680��$
��1280�� � 
ResizeMode$ CanMinimize=� � 	Resources ��%    .��� -    �Name$
 Main�� � RowDefinitions �� $
��125* ��� $
��524* �.+�� -   $ RibonBar��$��10q� �� $	��16* ��� $��5* �.+��� -    ��Name$ 	TopButton��$
��auto��$
��auto�� �� Orientation$ 
Horizontal=�.+��� -    ��Name$ BtnFCFS��$
��FCFS��$
��Left=�$��
10,10,0,10q�$	��205���� -   $ BtnHRRN��$!��Highest Response Radio Next��$
��Left=�$��	0,10,0,10q�$	��205���� -   $ BtnSJF��$��Shortest Job First��$
��Left=�$��	0,10,0,10q�$	��205���� -   $ BtnSRT��$��Shortest Remaining Time��$
��Left=�$��	0,10,0,10q�$	��205���� -   $ BtnPriority��$��Priority��$
��Left=�$��	0,10,0,10q�$	��205���� -	   $ BtnRoundRobin��$��Round-Robin��$
��Left=�$��	0,10,0,10q�$	��205���� -
   $ StaticControl��$ 
Horizontal=�$��1��.+��� -   $ BtnPreference��$��성능비교��$
��Left=�$��	60,0,10,0q�$��75�� � ToolTip$B <새 창에서 각 알고리즘의 결과를 보여줍니다.���� -   $ BtnReset��$
��Left=�$��	10,0,10,0q�$��25��$' !초기 상태로 되돌립니다.����Z� ��Z� ���� 	 �� ImageSource$	 	Reset.png���� -   
 ��Name$
 	TBPSCount��
������  �� TextAlignment$ Center=�$
��Left=�$��	10,0,10,0q�$	��200��$: 4시뮬레이션 될 프로세스의 개수입니다.��   WatermarkedTextBox#��[  
 � Tag$- '프로세스의 수를 입력하세요.������ *ProcessCount+ �� Mode$ TwoWay=� �� UpdateSourceTrigger$ PropertyChanged=�)  #ToggleSwitch.HorizontalToggleSwitch  -     Name$ ToggleCheck��$
��Left=�$��20��$��	10,0,10,0q�$��Stretch=�$��84��#  ToggleSwitch.ToggleSwitchBase   UncheckedContent$ 수동��   CheckedContent$ 자동��$4 .프로세스 생성 방법을 결정합니다.��� -   $ Content��$��10q�$��1�� � ColumnDefinitions �� $��1* ��� $��1* �.+�� -   $ LeftArea��$��10q�.+�7  1System.Windows.Forms.Integration.WindowsFormsHost  -     Name$	 WFH��   Child. ;  5System.Windows.Forms.DataVisualization.Charting.Chart  -   
chart1��� -   $ InfoArea��$��1��$��10q�$��2��  WpfApp3.ContentRight  -     Name$ RightControl��$��1��$��10q�