import React, { useState, useEffect } from 'react';
import { User, Lock, Eye, EyeOff, Settings, LogOut, UserPlus, Save, Edit, Trash2 } from 'lucide-react';

const PersonDatabaseApp = () => {
  const [currentView, setCurrentView] = useState('login');
  const [userRole, setUserRole] = useState(null);
  const [currentUser, setCurrentUser] = useState(null);
  const [users, setUsers] = useState([]);
  const [showPassword, setShowPassword] = useState(false);
  
  // Login credentials
  const [loginEmail, setLoginEmail] = useState('');
  const [loginPassword, setLoginPassword] = useState('');
  
  // Form data for user profile
  const [formData, setFormData] = useState({
    // Person
    FName: '', NName: '', BDay: '', Gender: '', CNumber: '', EAddress: '', Password: '',
    // Favorites
    FColor: '', FFood: '', FMovie: '', FSeries: '', FArtist: '', FSong: '', 
    FBook: '', FSubject: '', FHobby: '', FPlace: '', FQuote: '', FSports: '',
    // Personality
    DreamJob: '', CelebrityCrush: '', SuperPower: '', BiggestFear: '', 
    HappiestMemory: '', PetPeeves: '', DescWords: '', Traits: '', HiddenTalent: '',
    // Relationships
    BestFriend: '', RelationshipStatus: '', IdealDate: '', Crush: ''
  });

  // Load data from storage
  useEffect(() => {
    loadData();
  }, []);

  const loadData = async () => {
    try {
      const result = await window.storage.get('users-database');
      if (result) {
        setUsers(JSON.parse(result.value));
      }
    } catch (error) {
      console.log('No existing data or error loading:', error);
      setUsers([]);
    }
  };

  const saveData = async (updatedUsers) => {
    try {
      await window.storage.set('users-database', JSON.stringify(updatedUsers));
      setUsers(updatedUsers);
    } catch (error) {
      console.error('Error saving data:', error);
      alert('Failed to save data');
    }
  };

  const generateID = () => {
    return Date.now().toString(36) + Math.random().toString(36).substr(2);
  };

  const calculateAge = (birthday) => {
    if (!birthday) return 0;
    const today = new Date();
    const birthDate = new Date(birthday);
    let age = today.getFullYear() - birthDate.getFullYear();
    const monthDiff = today.getMonth() - birthDate.getMonth();
    if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < birthDate.getDate())) {
      age--;
    }
    return age;
  };

  const handleLogin = () => {
    // Admin login
    if (loginEmail === 'admin@db.com' && loginPassword === 'admin123') {
      setUserRole('admin');
      setCurrentUser({ FName: 'Administrator', EAddress: 'admin@db.com' });
      setCurrentView('adminDashboard');
      return;
    }

    // User login
    const user = users.find(u => u.EAddress === loginEmail && u.Password === loginPassword);
    if (user) {
      setUserRole('user');
      setCurrentUser(user);
      setCurrentView('userProfile');
    } else {
      alert('Invalid email or password');
    }
  };

  const handleRegister = () => {
    if (!formData.FName || !formData.EAddress || !formData.Password) {
      alert('Please fill in at least Full Name, Email, and Password');
      return;
    }

    // Check if email already exists
    if (users.find(u => u.EAddress === formData.EAddress)) {
      alert('Email already registered');
      return;
    }

    const newUser = {
      PersonID: generateID(),
      FavoriteID: generateID(),
      PersonalityID: generateID(),
      RelationshipID: generateID(),
      ...formData,
      Age: calculateAge(formData.BDay),
      CreatedAt: new Date().toISOString()
    };

    const updatedUsers = [...users, newUser];
    saveData(updatedUsers);
    alert('Registration successful! Please login.');
    setCurrentView('login');
    setFormData({
      FName: '', NName: '', BDay: '', Gender: '', CNumber: '', EAddress: '', Password: '',
      FColor: '', FFood: '', FMovie: '', FSeries: '', FArtist: '', FSong: '', 
      FBook: '', FSubject: '', FHobby: '', FPlace: '', FQuote: '', FSports: '',
      DreamJob: '', CelebrityCrush: '', SuperPower: '', BiggestFear: '', 
      HappiestMemory: '', PetPeeves: '', DescWords: '', Traits: '', HiddenTalent: '',
      BestFriend: '', RelationshipStatus: '', IdealDate: '', Crush: ''
    });
  };

  const handleUpdateProfile = () => {
    const updatedUsers = users.map(u => 
      u.PersonID === currentUser.PersonID 
        ? { ...currentUser, Age: calculateAge(currentUser.BDay) }
        : u
    );
    saveData(updatedUsers);
    alert('Profile updated successfully!');
  };

  const handleDeleteUser = (personId) => {
    if (window.confirm('Are you sure you want to delete this user?')) {
      const updatedUsers = users.filter(u => u.PersonID !== personId);
      saveData(updatedUsers);
    }
  };

  const handleLogout = () => {
    setCurrentView('login');
    setUserRole(null);
    setCurrentUser(null);
    setLoginEmail('');
    setLoginPassword('');
  };

  // Login View
  if (currentView === 'login') {
    return (
      <div className="min-h-screen bg-gradient-to-br from-blue-500 to-purple-600 flex items-center justify-center p-4">
        <div className="bg-white rounded-lg shadow-2xl p-8 w-full max-w-md">
          <div className="flex justify-center mb-6">
            <User className="w-16 h-16 text-blue-600" />
          </div>
          <h1 className="text-3xl font-bold text-center mb-6 text-gray-800">Person Database</h1>
          
          <div className="space-y-4">
            <div>
              <label className="block text-sm font-medium text-gray-700 mb-2">Email Address</label>
              <input
                type="email"
                value={loginEmail}
                onChange={(e) => setLoginEmail(e.target.value)}
                className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                placeholder="Enter your email"
              />
            </div>
            
            <div>
              <label className="block text-sm font-medium text-gray-700 mb-2">Password</label>
              <div className="relative">
                <input
                  type={showPassword ? "text" : "password"}
                  value={loginPassword}
                  onChange={(e) => setLoginPassword(e.target.value)}
                  className="w-full px-4 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500 focus:border-transparent"
                  placeholder="Enter your password"
                />
                <button
                  onClick={() => setShowPassword(!showPassword)}
                  className="absolute right-3 top-2.5 text-gray-500"
                >
                  {showPassword ? <EyeOff className="w-5 h-5" /> : <Eye className="w-5 h-5" />}
                </button>
              </div>
            </div>

            <button
              onClick={handleLogin}
              className="w-full bg-blue-600 text-white py-2 rounded-lg hover:bg-blue-700 transition font-medium"
            >
              Login
            </button>

            <div className="text-center text-sm text-gray-600">
              Don't have an account?
              <button
                onClick={() => setCurrentView('register')}
                className="text-blue-600 hover:text-blue-700 ml-1 font-medium"
              >
                Register here
              </button>
            </div>

            <div className="border-t pt-4 mt-4">
              <p className="text-xs text-gray-500 text-center">Admin Demo Login:</p>
              <p className="text-xs text-gray-600 text-center">Email: admin@db.com | Password: admin123</p>
            </div>
          </div>
        </div>
      </div>
    );
  }

  // Registration View
  if (currentView === 'register') {
    return (
      <div className="min-h-screen bg-gradient-to-br from-purple-500 to-pink-600 p-4 overflow-y-auto">
        <div className="max-w-4xl mx-auto bg-white rounded-lg shadow-2xl p-8 my-8">
          <h1 className="text-3xl font-bold text-center mb-8 text-gray-800">Create Your Profile</h1>
          
          {/* Basic Information */}
          <div className="mb-8">
            <h2 className="text-xl font-semibold mb-4 text-blue-600 border-b pb-2">Basic Information</h2>
            <div className="grid md:grid-cols-2 gap-4">
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-1">Full Name *</label>
                <input
                  type="text"
                  value={formData.FName}
                  onChange={(e) => setFormData({...formData, FName: e.target.value})}
                  className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500"
                  required
                />
              </div>
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-1">Nickname</label>
                <input
                  type="text"
                  value={formData.NName}
                  onChange={(e) => setFormData({...formData, NName: e.target.value})}
                  className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500"
                />
              </div>
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-1">Birthday</label>
                <input
                  type="date"
                  value={formData.BDay}
                  onChange={(e) => setFormData({...formData, BDay: e.target.value})}
                  className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500"
                />
              </div>
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-1">Gender</label>
                <select
                  value={formData.Gender}
                  onChange={(e) => setFormData({...formData, Gender: e.target.value})}
                  className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500"
                >
                  <option value="">Select Gender</option>
                  <option value="Male">Male</option>
                  <option value="Female">Female</option>
                  <option value="Other">Other</option>
                  <option value="Prefer not to say">Prefer not to say</option>
                </select>
              </div>
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-1">Contact Number</label>
                <input
                  type="tel"
                  value={formData.CNumber}
                  onChange={(e) => setFormData({...formData, CNumber: e.target.value})}
                  className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500"
                />
              </div>
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-1">Email Address *</label>
                <input
                  type="email"
                  value={formData.EAddress}
                  onChange={(e) => setFormData({...formData, EAddress: e.target.value})}
                  className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500"
                  required
                />
              </div>
              <div>
                <label className="block text-sm font-medium text-gray-700 mb-1">Password *</label>
                <input
                  type="password"
                  value={formData.Password}
                  onChange={(e) => setFormData({...formData, Password: e.target.value})}
                  className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-blue-500"
                  required
                />
              </div>
            </div>
          </div>

          {/* Favorites */}
          <div className="mb-8">
            <h2 className="text-xl font-semibold mb-4 text-purple-600 border-b pb-2">Personal Favorites</h2>
            <div className="grid md:grid-cols-2 gap-4">
              {['FColor', 'FFood', 'FMovie', 'FSeries', 'FArtist', 'FSong', 'FBook', 'FSubject', 'FHobby', 'FPlace', 'FQuote', 'FSports'].map(field => (
                <div key={field}>
                  <label className="block text-sm font-medium text-gray-700 mb-1">
                    {field.replace('F', 'Favorite ')}
                  </label>
                  <input
                    type="text"
                    value={formData[field]}
                    onChange={(e) => setFormData({...formData, [field]: e.target.value})}
                    className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-purple-500"
                  />
                </div>
              ))}
            </div>
          </div>

          {/* Personality */}
          <div className="mb-8">
            <h2 className="text-xl font-semibold mb-4 text-green-600 border-b pb-2">Fun Questions</h2>
            <div className="grid md:grid-cols-2 gap-4">
              {['DreamJob', 'CelebrityCrush', 'SuperPower', 'BiggestFear', 'HappiestMemory', 'PetPeeves', 'DescWords', 'Traits', 'HiddenTalent'].map(field => (
                <div key={field}>
                  <label className="block text-sm font-medium text-gray-700 mb-1">
                    {field.replace(/([A-Z])/g, ' $1').trim()}
                  </label>
                  {field === 'HappiestMemory' || field === 'PetPeeves' ? (
                    <textarea
                      value={formData[field]}
                      onChange={(e) => setFormData({...formData, [field]: e.target.value})}
                      className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-green-500"
                      rows="2"
                    />
                  ) : (
                    <input
                      type="text"
                      value={formData[field]}
                      onChange={(e) => setFormData({...formData, [field]: e.target.value})}
                      className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-green-500"
                    />
                  )}
                </div>
              ))}
            </div>
          </div>

          {/* Relationships */}
          <div className="mb-8">
            <h2 className="text-xl font-semibold mb-4 text-pink-600 border-b pb-2">Relationships & Social</h2>
            <div className="grid md:grid-cols-2 gap-4">
              {['BestFriend', 'RelationshipStatus', 'IdealDate', 'Crush'].map(field => (
                <div key={field}>
                  <label className="block text-sm font-medium text-gray-700 mb-1">
                    {field.replace(/([A-Z])/g, ' $1').trim()}
                  </label>
                  <input
                    type="text"
                    value={formData[field]}
                    onChange={(e) => setFormData({...formData, [field]: e.target.value})}
                    className="w-full px-3 py-2 border border-gray-300 rounded-lg focus:ring-2 focus:ring-pink-500"
                  />
                </div>
              ))}
            </div>
          </div>

          <div className="flex gap-4">
            <button
              onClick={handleRegister}
              className="flex-1 bg-gradient-to-r from-blue-600 to-purple-600 text-white py-3 rounded-lg hover:from-blue-700 hover:to-purple-700 transition font-medium flex items-center justify-center gap-2"
            >
              <UserPlus className="w-5 h-5" />
              Register
            </button>
            <button
              onClick={() => setCurrentView('login')}
              className="flex-1 bg-gray-300 text-gray-700 py-3 rounded-lg hover:bg-gray-400 transition font-medium"
            >
              Back to Login
            </button>
          </div>
        </div>
      </div>
    );
  }

  // User Profile View
  if (currentView === 'userProfile') {
    const [editMode, setEditMode] = useState(false);

    return (
      <div className="min-h-screen bg-gradient-to-br from-indigo-500 to-blue-600 p-4">
        <div className="max-w-6xl mx-auto">
          {/* Header */}
          <div className="bg-white rounded-lg shadow-lg p-6 mb-6 flex justify-between items-center">
            <div>
              <h1 className="text-2xl font-bold text-gray-800">Welcome, {currentUser.FName}!</h1>
              <p className="text-gray-600">{currentUser.EAddress}</p>
            </div>
            <div className="flex gap-2">
              <button
                onClick={() => setEditMode(!editMode)}
                className="flex items-center gap-2 bg-blue-600 text-white px-4 py-2 rounded-lg hover:bg-blue-700 transition"
              >
                <Edit className="w-4 h-4" />
                {editMode ? 'Cancel Edit' : 'Edit Profile'}
              </button>
              <button
                onClick={handleLogout}
                className="flex items-center gap-2 bg-red-600 text-white px-4 py-2 rounded-lg hover:bg-red-700 transition"
              >
                <LogOut className="w-4 h-4" />
                Logout
              </button>
            </div>
          </div>

          {/* Profile Content */}
          <div className="grid md:grid-cols-2 gap-6">
            {/* Basic Info */}
            <div className="bg-white rounded-lg shadow-lg p-6">
              <h2 className="text-xl font-bold mb-4 text-blue-600 border-b pb-2">Basic Information</h2>
              <div className="space-y-3">
                <div><strong>Full Name:</strong> {editMode ? (
                  <input type="text" value={currentUser.FName} onChange={(e) => setCurrentUser({...currentUser, FName: e.target.value})} className="ml-2 px-2 py-1 border rounded" />
                ) : currentUser.FName}</div>
                <div><strong>Nickname:</strong> {editMode ? (
                  <input type="text" value={currentUser.NName} onChange={(e) => setCurrentUser({...currentUser, NName: e.target.value})} className="ml-2 px-2 py-1 border rounded" />
                ) : currentUser.NName}</div>
                <div><strong>Birthday:</strong> {currentUser.BDay}</div>
                <div><strong>Age:</strong> {calculateAge(currentUser.BDay)} years old</div>
                <div><strong>Gender:</strong> {currentUser.Gender}</div>
                <div><strong>Contact:</strong> {currentUser.CNumber}</div>
              </div>
            </div>

            {/* Favorites */}
            <div className="bg-white rounded-lg shadow-lg p-6">
              <h2 className="text-xl font-bold mb-4 text-purple-600 border-b pb-2">Favorites</h2>
              <div className="space-y-2 text-sm">
                <div><strong>Color:</strong> {currentUser.FColor}</div>
                <div><strong>Food:</strong> {currentUser.FFood}</div>
                <div><strong>Movie:</strong> {currentUser.FMovie}</div>
                <div><strong>Series:</strong> {currentUser.FSeries}</div>
                <div><strong>Artist:</strong> {currentUser.FArtist}</div>
                <div><strong>Song:</strong> {currentUser.FSong}</div>
              </div>
            </div>

            {/* Personality */}
            <div className="bg-white rounded-lg shadow-lg p-6">
              <h2 className="text-xl font-bold mb-4 text-green-600 border-b pb-2">Personality</h2>
              <div className="space-y-2 text-sm">
                <div><strong>Dream Job:</strong> {currentUser.DreamJob}</div>
                <div><strong>Celebrity Crush:</strong> {currentUser.CelebrityCrush}</div>
                <div><strong>Superpower:</strong> {currentUser.SuperPower}</div>
                <div><strong>Biggest Fear:</strong> {currentUser.BiggestFear}</div>
                <div><strong>Best Trait:</strong> {currentUser.Traits}</div>
              </div>
            </div>

            {/* Relationships */}
            <div className="bg-white rounded-lg shadow-lg p-6">
              <h2 className="text-xl font-bold mb-4 text-pink-600 border-b pb-2">Relationships</h2>
              <div className="space-y-2 text-sm">
                <div><strong>Best Friend:</strong> {currentUser.BestFriend}</div>
                <div><strong>Status:</strong> {currentUser.RelationshipStatus}</div>
                <div><strong>Ideal Date:</strong> {currentUser.IdealDate}</div>
                <div><strong>Crush:</strong> {currentUser.Crush}</div>
              </div>
            </div>
          </div>

          {editMode && (
            <div className="mt-6 text-center">
              <button
                onClick={handleUpdateProfile}
                className="bg-green-600 text-white px-8 py-3 rounded-lg hover:bg-green-700 transition font-medium flex items-center justify-center gap-2 mx-auto"
              >
                <Save className="w-5 h-5" />
                Save Changes
              </button>
            </div>
          )}
        </div>
      </div>
    );
  }

  // Admin Dashboard
  if (currentView === 'adminDashboard') {
    return (
      <div className="min-h-screen bg-gradient-to-br from-gray-800 to-gray-900 p-4">
        <div className="max-w-7xl mx-auto">
          {/* Admin Header */}
          <div className="bg-white rounded-lg shadow-lg p-6 mb-6 flex justify-between items-center">
            <div className="flex items-center gap-3">
              <Settings className="w-8 h-8 text-gray-800" />
              <div>
                <h1 className="text-2xl font-bold text-gray-800">Admin Dashboard</h1>
                <p className="text-gray-600">Database Manager Portal</p>
              </div>
            </div>
            <button
              onClick={handleLogout}
              className="flex items-center gap-2 bg-red-600 text-white px-4 py-2 rounded-lg hover:bg-red-700 transition"
            >
              <LogOut className="w-4 h-4" />
              Logout
            </button>
          </div>

          {/* Statistics */}
          <div className="bg-white rounded-lg shadow-lg p-6 mb-6">
            <h2 className="text-xl font-bold mb-4">Database Statistics</h2>
            <div className="grid md:grid-cols-4 gap-4">
              <div className="bg-blue-100 p-4 rounded-lg">
                <p className="text-sm text-blue-600 font-medium">Total Users</p>
                <p className="text-3xl font-bold text-blue-800">{users.length}</p>
              </div>
              <div className="bg-green-100 p-4 rounded-lg">
                <p className="text-sm text-green-600 font-medium">Active Profiles</p>
                <p className="text-3xl font-bold text-green-800">{users.length}</p>
              </div>
              <div className="bg-purple-100 p-4 rounded-lg">
                <p className="text-sm text-purple-600 font-medium">Complete Profiles</p>
                <p className="text-3xl font-bold text-purple-800">
                  {users.filter(u => u.FName && u.BDay && u.Gender).length}
                </p>
              </div>
              <div className="bg-orange-100 p-4 rounded-lg">
                <p className="text-sm text-orange-600 font-medium">Avg Age</p>
                <p className="text-3xl font-bold text-orange-800">
                  {users.length > 0 ? Math.round(users.reduce((sum, u) => sum + calculateAge(u.BDay), 0) / users.length) : 0}
                </p>
              </div>
            </div>
          </div>

          {/* User List */}
          <div className="bg-white rounded-lg shadow-lg p-6">
            <h2 className="text-xl font-bold mb-4">User Database (Admin View)</h2>
            <div className="overflow-x-auto">
              <table className="w-full text-sm">
                <thead className="bg-gray-100">
                  <tr>
                    <th className="px-4 py-3 text-left font-semibold">PersonID</th>
                    <th className="px-4 py-3 text-left font-semibold">Full Name</th>
                    <th className="px-4 py-3 text-left font-semibold">Email</th>
                    <th className="px-4 py-3 text-left font-semibold">Age</th>
                    <th className="px-4 py-3 text-left font-semibold">Gender</th>
                    <th className="px-4 py-3 text-left font-semibold">FavoriteID</th>
                    <th className="px-4 py-3 text-left font-semibold">PersonalityID</th>
                    <th className="px-4 py-3 text-left font-semibold">RelationshipID</th>
                    <th className="px-4 py-3 text-left font-semibold">Actions</th>
                  </tr>
                </thead>
                <tbody>
                  {users.map((user) => (
                    <tr key={user.PersonID} className="border-b hover:bg-gray-50">
                      <td className="px-4 py-3 font-mono text-xs">{user.PersonID}</td>
                      <td className="px-4 py-3">{user.FName}</td>
                      <td className="px-4 py-3">{user.EAddress}</td>
                      <td className="px-4 py-3">{calculateAge(user.BDay)}</td>
                      <td className="px-4 py-3">{user.Gender}</td>
                      <td className="px-4 py-3 font-mono text-xs">{user.FavoriteID}</td>
                      <td className="px-4 py-3 font-mono text-xs">{user.PersonalityID}</td>
                      <td className="px-4 py-3 font-mono text-xs">{user.RelationshipID}</td>
                      <td className="px-4 py-3">
                        <button
                          onClick={() => handleDeleteUser(user.PersonID)}
                          className="text-red-600 hover:text-red-800"
                          title="Delete User"
                        >
                          <Trash2 className="w-4 h-4" />
                        </button>
                      </td>
                    </tr>
                  ))}
                </tbody>
              </table>
              {users.length === 0 && (
                <p className="text-center text-gray-500 py-8">No users registered yet</p>
              )}
            </div>
          </div>
        </div>
      </div>
    );
  }

  return null;
};

export default PersonDatabaseApp;