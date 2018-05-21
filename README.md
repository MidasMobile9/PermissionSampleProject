# PermissionSampleProject

 
사용방법.
 
1. Snackbar의 사용을 위해 app/gradle에 다음을 추가
<pre><code>implementation 'com.android.support:design:27.1.1'
</code></pre>
 
 
2. manifest에 다음과 같이 원하는 권한을 추가
<pre><code>< uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE" />
< uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE" />
< uses-permission android:name="android.permission.CAMERA" />
</code></pre>
 
 
3. 다음과 같이 원하는 권한을 String배열에 똑같이 추가하여 초기화
<pre><code>private String[] permissions = {
Manifest.permission.READ_EXTERNAL_STORAGE,
Manifest.permission.WRITE_EXTERNAL_STORAGE,
Manifest.permission.CAMERA
};
</code></pre>

 
 
4. 3번에서 만든 배열을 생성자의 인자를 넣으면서 다음과 같이 인스턴스 생성
<pre><code>mPermission = new Permission(this, permissions);
</code></pre>

 
5. 권한 요구 대화상자가 보여지기를 원하는 곳에 다음과 같이 선언
<pre><code>mPermission.checkPermissions();
</code></pre>

 
6. Snackbar가 보여지길 원한다면 다음의 함수를 5번과 함께 선언, view는 snackbar가 생성되는 view
<pre><code>setSnackbar(View);
</code></pre>

 
7. onRequestPermissionResult를 오버라이드하여 다음과 같이 선언
<pre><code>@Override public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
mPermission.requestPermissionsResult(requestCode, permissions, grantResults);
}
</code></pre>
이 함수는 유저가 Permission을 승인하거나 거부 하면 콜백되는 함수임
