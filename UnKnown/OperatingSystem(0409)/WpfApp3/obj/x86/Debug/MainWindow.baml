   M S B A M L   `   `   `  ����C  ?GanttWPF, Version=1.0.0.0, Culture=neutral, PublicKeyToken=nullM4clr-namespace:SCADAServis.Controls;assembly=GanttWPFSCADAServis.Controls  5   	   [ WSystem.Windows.Forms, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089Y@clr-namespace:System.Windows.Forms;assembly=System.Windows.FormsSystem.Windows.Forms 5   	   m iSystem.Windows.Forms.DataVisualization, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35�mclr-namespace:System.Windows.Forms.DataVisualization.Charting;assembly=System.Windows.Forms.DataVisualization/System.Windows.Forms.DataVisualization.Charting 5   	   B >WpfApp3, Version=1.0.0.0, Culture=neutral, PublicKeyToken=null!clr-namespace:WpfApp3WpfApp3 5   	   S OToggleSwitch, Version=1.1.2.0, Culture=neutral, PublicKeyToken=8637099990568f75A0clr-namespace:ToggleSwitch;assembly=ToggleSwitchToggleSwitch 5	   	      WpfApp3.MainWindow   5   	   AControls4clr-namespace:SCADAServis.Controls;assembly=GanttWPF  \ XPresentationFramework, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35R NWindowsBase, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35^ ZWindowsFormsIntegration, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35W SPresentationCore, Version=4.0.0.0, Culture=neutral, PublicKeyToken=31bf3856ad364e35U	 QWPFToolkit, Version=3.5.40128.1, Culture=neutral, PublicKeyToken=31bf3856ad364e35H 9http://schemas.microsoft.com/winfx/2006/xaml/presentation     	 5   	   R
 NSystem.Xaml, Version=4.0.0.0, Culture=neutral, PublicKeyToken=b77a5c561934e089:x,http://schemas.microsoft.com/winfx/2006/xaml 
    5   	   @d2http://schemas.microsoft.com/expression/blend/2008 
    5   	   Jmc;http://schemas.openxmlformats.org/markup-compatibility/2006 
    5   	   Owf@clr-namespace:System.Windows.Forms;assembly=System.Windows.Forms 
    5   	   �mschartmclr-namespace:System.Windows.Forms.DataVisualization.Charting;assembly=System.Windows.Forms.DataVisualization 
    5   	   'localclr-namespace:WpfApp3 
    5   	   IToggleSwitch0clr-namespace:ToggleSwitch;assembly=ToggleSwitch 
    5	   	     � Title$&   CPU 스케쥴링 시뮬레이션��5   	   $	��680��6    $
��1280��6-    � 
ResizeMode$ CanMinimize=�6:    � 	Resources 5      ��%    5      .��5      � -   5         �Name$
 Main��5       � RowDefinitions 5   
   �� 5      $
��125* �6   �� 5      $
��524* �6   .+�5   
   � -   5        $ RibonBar��5      $��10q�6!    5      �� 5      $	��16* �6    �� 5      $��5* �6    .+�5      �� -   5         ��Name$ 	TopButton��5      $
��auto��6,   $
��auto��69    �� Orientation$ 
Horizontal=�6G   .+�5      �� -   5         ��Name$ BtnFCFS��5      $
��FCFS��6*   $
��Left=�69   $��
10,10,0,10q�6T   $	��205��6h   �� 5      -   5        $ BtnHRRN��5      $!��Highest Response Radio Next��6*   $
��Left=�6P   $��	0,10,0,10q�6k   $	��205��6~   �� 5      -   5        $ BtnSJF��5      $��Shortest Job First��6)   $
��Left=�6F   $��	0,10,0,10q�6a   $	��205��6t   �� 5      -   5        $ BtnSRT��5      $��Shortest Remaining Time��6)   $
��Left=�6K   $��	0,10,0,10q�6f   $	��205��6y   �� 5      -   5        $ BtnPriority��5      $��Priority��6.   $
��Left=�6A   $��	0,10,0,10q�6\   $	��205��6o   �� 5      -	   5        $ BtnRoundRobin��5      $��Round-Robin��60   $
��Left=�6F   $��	0,10,0,10q�6a   $	��205��6t   5       �� 5!      -
   5        $ StaticControl��5!      $ 
Horizontal=�60   $��1��6I   .+�5"      �� -   5        $ BtnPreference��5"      $��성능비교��60   $
��Left=�6?   $��	60,0,10,0q�6Z   $��75��6m    � ToolTip$B <새 창에서 각 알고리즘의 결과를 보여줍니다.��6x   �� 5#      -   5        $ BtnReset��5#      $
��Left=�6+   $��	10,0,10,0q�6F   $��25��6Y   $' !초기 상태로 되돌립니다.��6�   ��6d   Z� ��6{   Z� ��5$      �� 5%      	 �� ImageSource$	 	Reset.png��6%   5'      �� 5)      -   5        
 ��Name$
 	TBPSCount��5)      
������  �� TextAlignment$ Center=�6F   $
��Left=�6]   $��	10,0,10,0q�6x   $	��200��6�   $: 4시뮬레이션 될 프로세스의 개수입니다.��6�      WatermarkedTextBox#��[  6�   
 � Tag$- '프로세스의 수를 입력하세요.��6�   ��6  �� *ProcessCount+ �� Mode$ TwoWay=� �� UpdateSourceTrigger$ PropertyChanged=�6c  )  #ToggleSwitch.HorizontalToggleSwitch  5*      -   5          Name$ ToggleCheck��5*   6   $
��Left=�6K   $��20��6f   $��	10,0,10,0q�6r   $��Stretch=�6�   $��84��6�   #  ToggleSwitch.ToggleSwitchBase   UncheckedContent$ 수동��6�      CheckedContent$ 자동��6�   $4 .프로세스 생성 방법을 결정합니다.��6�   6  5+      5,      � 5-   
   -   5        $ Content��5-      $��10q�6    $��1��6,    � ColumnDefinitions 5.      �� 5/      $��1* �6#   �� 50      $��1* �6#   .+�52      � -   5        $ LeftArea��52      $��10q�6%   .+�53      7  1System.Windows.Forms.Integration.WindowsFormsHost  -   5          Name$	 WFH��53   #      Child. 54      ;  5System.Windows.Forms.DataVisualization.Charting.Chart  -   5        
chart1��54   $   55      56      � 57      -   5        $ InfoArea��57      $��1��6%   $��10q�65   $��2��6A     WpfApp3.ContentRight  58      -   5          Name$ RightControl��58   !   $��1��67   $��10q�6G   59      5:      5;      